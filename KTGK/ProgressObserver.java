public interface ProgressObserver {
    void onWordAdded(Word word);
}

class LearningProgress implements ProgressObserver {
    private int total = 0;

    @Override
    public void onWordAdded(Word word) {
        total++;
        System.out.println("[Thong bao] Tu moi da duoc them! Tong: " + total);
    }
}
