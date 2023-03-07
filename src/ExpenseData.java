class ExpenseData {
    private final String[] categories = {"Groceries", "Utilities", "Medical", "Others"};
    private final double[] totals = new double[categories.length];
    private final int[] counts = new int[categories.length];
    private final StringBuilder[] expenseLists = new StringBuilder[categories.length];

    public ExpenseData() {
        for (int i = 0; i < categories.length; i++) {
            expenseLists[i] = new StringBuilder();
        }
    }

    public void addExpense(String category, Double expense) {
        int index = getCategoryIndex(category);
        double amount = expense;
        totals[index] += amount;
        counts[index]++;
        expenseLists[index].append(category).append(": RM").append(expense).append("\n");
    }

    public String getExpenseList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < categories.length; i++) {
            sb.append(expenseLists[i]);
        }
        return sb.toString();
    }

    public String getFilteredExpenses(String category) {
        int index = getCategoryIndex(category);
        return expenseLists[index].toString();
    }

    public double getAverageExpense(String category) {
        int index = getCategoryIndex(category);
        return counts[index] == 0 ? 0 : totals[index] / counts[index];
    }

    private int getCategoryIndex(String category) {
        for (int i = 0; i < categories.length; i++) {
            if (category.equals(categories[i])) {
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid category: " + category);
    }
}
