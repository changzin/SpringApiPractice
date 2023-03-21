package Changzin.SpringApiPractice.domain;

public class Member {
    private Long id;
    private String email;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void print(){
        System.out.println(this.id);
        System.out.println(this.email);
        System.out.println(this.password);
        return;
    }
}
