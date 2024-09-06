package QUESTION_1;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest
{
    @Test
    public void TestSaveStudent()
    {
        // Arrange
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        
        // Act
        Student.SaveStudent(student);
        Student result = Student.SearchStudent("10111");
        
        // Assert
        assertNotNull(result);
        assertEquals("J.Bloggs", result.getName());
    }

    @Test
    public void TestSearchStudent()
    {
        // Arrange
        Student student = new Student("10112", "J.Doe", 21, "jdoe@ymail.com", "disd");
        Student.SaveStudent(student);
        
        // Act
        Student result = Student.SearchStudent("10112");
        
        // Assert
        assertNotNull(result);
        assertEquals("J.Doe", result.getName());
    }

    @Test
    public void TestSearchStudent_StudentNotFound()
    {
        // Act
        Student result = Student.SearchStudent("99999");
        
        // Assert
        assertNull(result);
    }

    @Test
    public void TestDeleteStudent()
    {
        // Arrange
        Student student = new Student("10113", "P.Parker", 20, "spidey@ymail.com", "disn");
        Student.SaveStudent(student);
        
        // Act
        boolean deleted = Student.DeleteStudent("10113");
        
        // Assert
        assertTrue(deleted);
        assertNull(Student.SearchStudent("10113"));
    }

    @Test
    public void TestDeleteStudent_StudentNotFound()
    {
        // Act
        boolean deleted = Student.DeleteStudent("55555");
        
        // Assert
        assertFalse(deleted);
    }

    @Test
    public void TestStudentAge_StudentAgeValid()
    {
        // Act & Assert
        assertTrue(isValidAge("18"));
    }

    @Test
    public void TestStudentAge_StudentAgeInvalid()
    {
        // Act & Assert
        assertFalse(isValidAge("10"));
    }

    @Test
    public void TestStudentAge_StudentAgeInvalidCharacter()
    {
        // Act & Assert
        try
        {
            Integer.parseInt("c");
            fail("Expected NumberFormatException not thrown");
        }
        catch (NumberFormatException e)
        {
            // Expected exception, test passes
        }
    }

    private boolean isValidAge(String ageInput)
    {
        try
        {
            int age = Integer.parseInt(ageInput);
            return age >= 16;
        }                                                                                                                                                                                                                                                                                                   
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}
