package vn.ryan.core.constants;

public enum ReportForm {
    REMEMBER_KNOWLEDGE("Ghi nhớ kiến thức"),
    UNDERSTAND_KNOWLEDGE("Hiểu chắc kiến thức"),
    APPLYING_KNOWLEDGE_TO_SOLVE_SIMPLE_EXERCISES("Vận dụng kiến thức giải bài tập đơn giản"),
    APPLYING_KNOWLEDGE_TO_SOLVE_COMPLEX_EXERCISES("Vận dụng kiến thức giải bài tập phức tạp"),
    APPLYING_KNOWLEDGE_TO_SOLVE_ADVANCED_EXERCISES("Vận dụng kiến thức giải bài tập nâng cao");

    private final String values;

    ReportForm(String values) {
        this.values = values;
    }

    public String getValues() {
        return this.values;
    }
}
