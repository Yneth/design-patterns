package ua.abond.pattern.state;

public class Scholarship {
    private ScholarshipState state;

    public Scholarship(Student student) {
        this.state = new CreatedState();
    }

    public void withdraw() {
        this.state = new WithdrawnState();
    }

    public void setState(ScholarshipState state) {
        this.state = state;
    }
}
