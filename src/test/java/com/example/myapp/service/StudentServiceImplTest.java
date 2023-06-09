package com.example.myapp.service;

import com.example.myapp.StudentTestData;
import com.example.myapp.dto.StudentDTO;
import com.example.myapp.exception.ResourceNotFoundException;
import com.example.myapp.model.Student;
import com.example.myapp.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentTestData studentTestData;
    
    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateStudent() {
    	
        StudentDTO studentDTO = studentTestData.getStudentDTOData();
        Student savedStudent = studentTestData.getStudentData();
        when(studentRepository.save(any(Student.class))).thenReturn(savedStudent);
        Student result = studentService.createStudent(studentDTO);
        
        assertNotNull(result);
        assertEquals(savedStudent.getId(), result.getId());
        assertEquals(savedStudent.getName(), result.getName());

        verify(studentRepository, times(1)).save(any(Student.class));
    }

    @Test
    void testGetStudentsById_ExistingId() {
        Long existingId = 1L;
        Student existingStudent = studentTestData.getStudentData();
        when(studentRepository.findById(existingId)).thenReturn(Optional.of(existingStudent));
        List<Student> result = studentService.getStudents(existingId);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(existingStudent.getId(), result.get(0).getId());
        assertEquals(existingStudent.getName(), result.get(0).getName());
        
        verify(studentRepository, times(1)).findById(existingId);
    }

    @Test
    void testGetStudentsById_NonExistingId() {
        Long nonExistingId = 999L;

        when(studentRepository.findById(nonExistingId)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> studentService.getStudents(nonExistingId));

        verify(studentRepository, times(1)).findById(nonExistingId);
    }

    @Test
    void testGetStudents_All() {
        List<Student> students = new ArrayList<>();
        List<Student> result = studentService.getStudents(null);
        when(studentRepository.findAll()).thenReturn(students);

        assertNotNull(result);
        assertEquals(students.size(), result.size());
        
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void testUpdateStudent_ExistingId() {
        Long existingId = 1L;
        StudentDTO studentDTO = studentTestData.getStudentDTOData();
        Student existingStudent = studentTestData.getStudentData();
        Student updatedStudent =  studentTestData.getStudentData();
        
        when(studentRepository.findById(existingId)).thenReturn(Optional.of(existingStudent));
        when(studentRepository.save(any(Student.class))).thenReturn(updatedStudent);
        Student result = studentService.updateStudent(existingId, studentDTO);
        
        assertNotNull(result);
        assertEquals(updatedStudent.getId(), result.getId());
        assertEquals(updatedStudent.getName(), result.getName());

        verify(studentRepository, times(1)).findById(existingId);
        verify(studentRepository, times(1)).save(any(Student.class));
    }

    @Test
    void testUpdateStudent_NonExistingId() {
        Long nonExistingId = 999L;

        StudentDTO studentDTO =  studentTestData.getStudentDTOData();
        when(studentRepository.findById(nonExistingId)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> studentService.updateStudent(nonExistingId, studentDTO));

        verify(studentRepository, times(1)).findById(nonExistingId);
    }

    @Test
    void testDeleteStudent_ExistingId() {
        Long existingId = 1L;

        Student existingStudent = studentTestData.getStudentData();
        when(studentRepository.findById(existingId)).thenReturn(Optional.of(existingStudent));
        String result = studentService.deleteStudent(existingId);

        assertNotNull(result);
        assertEquals("Student with id " + existingId + " has been deleted.", result);
        
        verify(studentRepository, times(1)).findById(existingId);
        verify(studentRepository, times(1)).delete(existingStudent);
    }

    @Test
    void testDeleteStudent_NonExistingId() {
        Long nonExistingId = 999L;

        when(studentRepository.findById(nonExistingId)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> studentService.deleteStudent(nonExistingId));

        verify(studentRepository, times(1)).findById(nonExistingId);
    }
}
