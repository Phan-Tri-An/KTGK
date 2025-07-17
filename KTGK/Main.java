import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VocabularyManager vm = VocabularyManager.getInstance();
        LearningProgress progress = new LearningProgress();
        vm.registerObserver(progress);
        vm.addWord(new Word("apple", "qua tao", "I eat an apple."));
        vm.addWord(new Word("book", "quyen sach", "This is my favorite book."));
        vm.addWord(new Word("computer", "may tinh", "I use a computer for work."));
        vm.addWord(new Word("dog", "con cho", "My dog is very friendly."));
        vm.addWord(new Word("elephant", "con voi", "The elephant is the largest land animal."));
        vm.addWord(new Word("flower", "hoa", "The flower is blooming in the garden."));
        vm.addWord(new Word("house", "ngoi nha", "They live in a big house."));
        vm.addWord(new Word("island", "dao", "The island is surrounded by the sea."));
        Scanner scanner = new Scanner(System.in); // chỉ khai báo 1 lần

        // Vòng lặp menu
        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Hoc theo Flashcard");
            System.out.println("2. Hoc theo Quiz ABCD");
            System.out.println("3. Them tu moi");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            int choice = Integer.parseInt(scanner.nextLine().trim());

            if (choice == 0) {
                System.out.println("Tam biet!");
                break;
            }

            switch (choice) {
                case 1 -> {
                    LearningStrategy flash = new FlashcardStrategy();
                    flash.learn(vm.getAllWords());
                }
                case 2 -> {
                    LearningStrategy quiz = new MultipleChoiceQuizStrategy();
                    quiz.learn(vm.getAllWords());
                }
                case 3 -> {
                    System.out.print("Nhap tu tieng Anh: ");
                    String term = scanner.nextLine();
                    if (vm.isWordExists(term)) {
                     System.out.println("Tu da ton tai, khong them lai.");
                    } else {
                        System.out.print("Nhap nghia khong dau: ");
                        String meaning = scanner.nextLine();
                        System.out.print("Nhap vi du (neu co): ");
                        String example = scanner.nextLine();
                        vm.addWord(new Word(term, meaning, example));
                        System.out.println("Tu da duoc them.");
}
                }
                default -> System.out.println("Lua chon khong hop le.");
            }
        }
    }
}
