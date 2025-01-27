/*
 * package com.school.database.school;
 * 
 * import java.util.Optional;
 * 
 * import static org.assertj.core.api.Assertions.assertThat;
 * import static org.assertj.core.api.Assertions.assertThatThrownBy;
 * import org.junit.jupiter.api.Test;
 * import static org.mockito.ArgumentMatchers.anyLong;
 * import org.mockito.InjectMocks;
 * import org.mockito.Mock;
 * import static org.mockito.Mockito.never;
 * import static org.mockito.Mockito.times;
 * import static org.mockito.Mockito.verify;
 * import static org.mockito.Mockito.when;
 * import org.springframework.boot.test.context.SpringBootTest;
 * 
 * import com.school.database.school.model.Student;
 * import com.school.database.school.service.StudentService;
 * import com.school.database.school.repository.StudentRepository;
 * import com.school.database.school.exception.StudentNotFoundException;
 * 
 * @SpringBootTest
 * public class StudentServiceTest {
 * 
 * @Mock
 * private StudentRepository repository;
 * 
 * @InjectMocks
 * private StudentService service;
 * 
 * @Test
 * public void saveStudentTest() {
 * Student newStudent = new Student("Batuhan Akin", "Computer Science", 24);
 * when(repository.save(newStudent)).thenReturn(newStudent);
 * 
 * Student savedStudent = service.saveStudent(newStudent);
 * 
 * assertThat(savedStudent.getName()).isEqualTo("Batuhan Akin");
 * assertThat(savedStudent.getMajor()).isEqualTo("Computer Science");
 * assertThat(savedStudent.getAge()).isEqualTo(24);
 * verify(repository, times(1)).save(newStudent);
 * }
 * 
 * @Test
 * public void findStudentByIdTest() {
 * Long studentId = 1L;
 * Student student = new Student("Batuhan Akin", "Computer Science", 24);
 * when(repository.findById(studentId)).thenReturn(Optional.of(student));
 * 
 * Student foundStudent = service.findStudentById(studentId);
 * 
 * assertThat(foundStudent.getName()).isEqualTo("Batuhan Akin");
 * assertThat(foundStudent.getMajor()).isEqualTo("Computer Science");
 * assertThat(foundStudent.getAge()).isEqualTo(24);
 * verify(repository, times(1)).save(foundStudent);
 * }
 * 
 * @Test
 * public void findStudentById_NotFoundTest() {
 * Long studentId = 99L;
 * when(repository.findById(studentId)).thenReturn(Optional.empty());
 * 
 * assertThatThrownBy(() ->
 * service.findStudentById(studentId)).isInstanceOf(StudentNotFoundException.
 * class)
 * .hasMessage("Could not find student " + studentId);
 * verify(repository, times(1)).findById(studentId);
 * }
 * 
 * @Test
 * public void deleteStudentTest() {
 * Long studentId = 1L;
 * when(repository.existsById(studentId)).thenReturn(true);
 * 
 * service.deleteStudent(studentId);
 * 
 * verify(repository, times(1)).deleteById(studentId);
 * }
 * 
 * @Test
 * public void testDeleteStudent_NotFound() {
 * 
 * Long studentId = 99L;
 * when(repository.existsById(studentId)).thenReturn(false);
 * 
 * assertThatThrownBy(() -> service.deleteStudent(studentId))
 * .isInstanceOf(StudentNotFoundException.class)
 * .hasMessage("Could not find student " + studentId);
 * 
 * verify(repository, never()).deleteById(anyLong());
 * }
 * }
 */