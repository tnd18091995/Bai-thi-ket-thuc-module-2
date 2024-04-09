package storage;
import model.Student;
import java.util.List;

public interface IReadWriteFile {
        List<Student> readFile();
        void writeFile(List<Student> studentList);
}
