import java.util.*;

public interface LearningStrategy {
    void learn(List<Word> words);
}

class FlashcardStrategy implements LearningStrategy {
    @Override
    public void learn(List<Word> words) {
        Scanner sc = new Scanner(System.in);
        for (Word word : words) {
            System.out.println("Tu: " + word.getTerm());
            System.out.println("Nhan Enter de xem nghia...");
            sc.nextLine();
            System.out.println("Nghia: " + word.getMeaning());
            System.out.println("---");
        }
    }
}

class MultipleChoiceQuizStrategy implements LearningStrategy {
    @Override
    public void learn(List<Word> words) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        List<String> allMeanings = new ArrayList<>();
        for (Word w : words) {
            allMeanings.add(w.getMeaning());
        }

        for (Word word : words) {
            System.out.println("Tu: " + word.getTerm());

            Set<String> choices = new HashSet<>();
            choices.add(word.getMeaning());

            while (choices.size() < 4 && choices.size() < allMeanings.size()) {
                String randomMeaning = allMeanings.get(rand.nextInt(allMeanings.size()));
                if (!randomMeaning.equals(word.getMeaning())) {
                    choices.add(randomMeaning);
                }
            }

            List<String> shuffled = new ArrayList<>(choices);
            Collections.shuffle(shuffled);

            char option = 'A';
            Map<Character, String> optionMap = new LinkedHashMap<>();
            for (String choice : shuffled) {
                optionMap.put(option, choice);
                option++;
            }

            for (Map.Entry<Character, String> entry : optionMap.entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue());
            }

            System.out.print("Chon dap an (A/B/C/D): ");
            String answer = scanner.nextLine().trim().toUpperCase();
            String selected = optionMap.getOrDefault(answer.charAt(0), "");

            if (selected.equals(word.getMeaning())) {
                System.out.println("Dung!");
            } else {
                System.out.println("Sai. Dap an dung la: " + word.getMeaning());
            }
            System.out.println("---");
        }
    }
}
