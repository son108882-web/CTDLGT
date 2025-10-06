package linked_list;

public class StudentMS {
    private LinkedList<Student> list; // Danh sách sinh viên (dạng LinkedList)

    // Constructor khởi tạo danh sách rỗng
    public StudentMS() {
        this.list = new LinkedList<>();
    }

    // Thêm sinh viên vào cuối danh sách
    public void addStudent(Student student) {
        this.list.addLast(student);
    }

    // In danh sách sinh viên
    public void printList() {
        this.list.traverse();
    }

    // Tìm sinh viên (dựa vào equals trong Student)
    public boolean findStudent(Student student) {
        return list.findItem(student);
    }

    // Cập nhật thông tin sinh viên theo ID
    public boolean update(Student student) {
        Node<Student> tmp = list.getHead();
        while (tmp != null) {
            Student st = tmp.getData();
            if (st.getId().equals(student.getId())) {  // Nếu ID trùng khớp
                st.setFullName(student.getFullName());
                st.setAge(student.getAge());
                st.setGpa(student.getGpa());
                return true;  // Cập nhật thành công
            }
            tmp = tmp.getNext();
        }
        return false; // Không tìm thấy sinh viên để cập nhật
    }

    // Xóa sinh viên khỏi danh sách
    public void remove(Student student) {
        this.list.remove(student);
    }

    // Đếm số sinh viên có cùng tên
    public int countStudent(String fullName) {
        int count = 0;
        Node<Student> tmp = list.getHead();
        while (tmp != null) {
            Student st = tmp.getData();
            if (st.getFullName().equals(fullName)) {
                count++;
            }
            tmp = tmp.getNext();
        }
        return count;
    }
}
