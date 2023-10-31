package vn.ryan.core.constants;

public enum ReportComment {
    /**
     * Đưa vào điểm mạnh mặc định
     */
    DEFAULT_STRONG("Con đã có ý thức tham gia học tập và hoàn thành bài tập được giao."),
    /**
     * Đưa vào điểm yếu mặc định
     */
    DEFAULT_WEAK("Con cần luyện tập nhiều hơn để đạt điểm tối đa, và rút ngắn thời gian làm bài."),
    /**
     * Đưa vào điểm cần cải thiện (dưới 6 điểm)
     */
    REMEMBER_KNOWLEDGE_NEED_TO_IMPROVE("Con chưa ghi nhớ được các kiến thức cơ bản của bài học. Con cần dành nhiều thời gian hơn để xem lại những kiến thức cơ bản."),
    UNDERSTAND_KNOWLEDGE_NEED_TO_IMPROVE("Con chưa nắm vững được những kiến thức cơ bản của bài học. Con cần thực hành luyện tập nhiều bài tập hơn"),
    APPLYING_KNOWLEDGE_TO_SOLVE_SIMPLE_EXERCISES_NEED_TO_IMPROVE("Con chưa kết nối được kiến thức đã học vào những tình huống đơn giản. Con cần ghi nhớ kỹ phương pháp giáo viên dạy để áp dụng vào giải các dạng bài tương tự."),
    APPLYING_KNOWLEDGE_TO_SOLVE_COMPLEX_EXERCISES_NEED_TO_IMPROVE("Con chưa kết nối được những kiến thức đã học vào các tình huống phức tạp. Con cần ghi nhớ kỹ phương pháp giáo viên dạy để áp dụng vào giải các dạng bài tập phức tạp hơn."),
    APPLYING_KNOWLEDGE_TO_SOLVE_ADVANCED_EXERCISES_NEED_TO_IMPROVE("Con chưa kết nối được những kiến thức đã học vào các tình huống có độ khó cao. Con cần ghi nhớ kỹ phương pháp giáo viên dạy để áp dụng vào giải các dạng bài tập có độ khó cao."),
    /**
     * Đưa vào điểm mạnh (6 - 8 điểm)
     */
    REMEMBER_KNOWLEDGE_STRENGTH("Con đã ghi nhớ được những kiến thức cơ bản của bài học nhưng đôi chỗ vẫn còn nhầm lẫn."),
    UNDERSTAND_KNOWLEDGE_STRENGTH("Con đã hiểu được những kiến thức cơ bản của bài học nhưng chưa thực sự chắc chắn."),
    APPLYING_KNOWLEDGE_TO_SOLVE_SIMPLE_EXERCISES_STRENGTH("Con đã biết cách vận dụng kiến thức để giải các dạng bài đơn giản, cần luyện tập nhiều hơn."),
    APPLYING_KNOWLEDGE_TO_SOLVE_COMPLEX_EXERCISES_STRENGTH("Con đã biết kết hợp kiến thức và tư duy phân tích để giải các dạng bài phức tạp, nhưng chưa hoàn toàn chính xác."),
    APPLYING_KNOWLEDGE_TO_SOLVE_ADVANCED_EXERCISES_STRENGTH("Con đã bước đầu vận dụng được kiến thức đã học vào những tình huống có độ khó cao, tuy nhiên con cần rèn luyện thêm các thao tác tư duy bậc cao như khái quát hóa, liên tưởng, dự đoán để việc vận dụng được hiệu quả hơn."),
    /**
     * Đưa vào điểm mạnh mẽ (8 - 10 điểm)
     */
    REMEMBER_KNOWLEDGE_POWERFUL("Con đã ghi nhớ được những kiến thức cơ bản của bài học."),
    UNDERSTAND_KNOWLEDGE_POWERFUL("Con đã nẵm vững chắc chắn được những kiến thức cơ bản của bài học."),
    APPLYING_KNOWLEDGE_TO_SOLVE_SIMPLE_EXERCISES_POWERFUL("Con đã vận dụng được những kiến thức đã học vào các tình huống thực tiễn đơn giản."),
    APPLYING_KNOWLEDGE_TO_SOLVE_COMPLEX_EXERCISES_POWERFUL("Con đã vận dụng được kiến thức, kết hợp tư duy phân tích để giải các dạng bài phức tạp."),
    APPLYING_KNOWLEDGE_TO_SOLVE_ADVANCED_EXERCISES_POWERFUL("Con đã vận dụng được thành thạo kiến thức đã học vào các dạng bài tập có độ khó cao. Cần tiếp tục phát huy.");


    private final String values;

    ReportComment(String values) {
        this.values = values;
    }

    public String getValues() {
        return this.values;
    }
}
