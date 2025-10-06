package linked_list;

public class Student {
    private String id;
    private String fullName;
    private int age;
    private float gpa;

    public Student() {    // Constructor mặc định (rỗng)
    }

    // Constructor có tham số
    public Student(String id, String fullName, int age, float gpa) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gpa = gpa;
    }

    // Getter - Setter cho từng thuộc tính
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    // Ghi đè (Override) phương thức toString()
    @Override
    public String toString() {
        return "Student [id=" + id + ", fullName=" + fullName + ", age=" + age + ", gpa=" + gpa + "]";
    }

    // Ghi đè hashCode() để hỗ trợ so sánh đối tượng
    @Override
    public int hashCode() {
        final int prime = 31;   // prime: số nguyên tố
        int result = 1; // Khởi tạo giá trị ban đầu = 1
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + age;
        result = prime * result + Float.floatToIntBits(gpa);
        return result;
    }

    // Ghi đè equals() để so sánh hai sinh viên
    @Override
    public boolean equals(Object obj) {
        // Nếu cùng trỏ tới 1 đối tượng thì bằng nhau
        if (this == obj)
            return true;

        // Nếu obj null hoặc khác lớp -> false
        if (obj == null || getClass() != obj.getClass())
            return false;

        // Ép kiểu về Student
        Student other = (Student) obj;

        // So sánh từng thuộc tính
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;

        if (fullName == null) {
            if (other.fullName != null)
                return false;
        } else if (!fullName.equals(other.fullName))
            return false;

        if (age != other.age)
            return false;

        if (Float.floatToIntBits(gpa) != Float.floatToIntBits(other.gpa))
            return false;

        return true;
    }
}
