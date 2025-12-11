public class Question {// Class to represent a question with options
  private String question;// The question text
  private String[] options;// The possible options for the question
// Constructor to initialize Question object
public class MultipleChoiceQuestion extends Question { // Inherits from Question class
  private String correctAnswer; // The correct answer for the question

  // Constructor to initialize MultipleChoiceQuestion object
  public MultipleChoiceQuestion(String question, String[] options, String correctAnswer) {
    super(question, options); // Call the parent constructor
    this.correctAnswer = correctAnswer; // Initialize the correct answer
  }

  // Getter method for correct answer
  public String getCorrectAnswer() {
    return correctAnswer;
  }

  // Setter method for correct answer
  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }
}
  public Question(String question, String[] options) { // Constructor to initialize Question object
    this.question = question;
    this.options = options;
  }// End of constructor
// Getter and setter methods for the Question class attributes
  public String getQuestion() {
    return question;
  }// End of getter method
// Setter method for question
  public void setQuestion(String question) {
    this.question = question;
  }

  public String[] getOptions() {
    return options;
  }

  public void setOptions(String[] options) {
    this.options = options;
  }// End of setter method
}// End of Question class
