
# Exercise 7: Financial Forecasting (Java)

# Scenario:
You are developing a financial forecasting tool that predicts future values based on past data.

This tool allows users to:
- Input an initial amount
- Enter an annual growth rate
- Choose the number of years to forecast
- See the predicted future value using a recursive calculation

---

# Steps Followed

# 1. Understand Recursive Algorithms:
Recursion involves a method calling itself.  
In this exercise, recursion is used to apply a growth rate over multiple years.
```
FutureValue(n) = FutureValue(n-1) × (1 + rate)
```

# 2. Setup:
Defined a method:
```
public static double predictFutureValue(int years, double amount, double rate)
```

# 3. Implementation:

- Written in Java
- Uses `Scanner` for user input
- Calculates future value recursively

# 4. Analysis:
**Time Complexity:**  
`O(n)` → One recursive call for each year

# To avoid excessive computations for larger datasets,iteration or memoization can be used to reduce stack usage.
Convert to Iterative Solution
Avoid recursion altogether:
  public static double predictFutureValueIterative(int years, double amount, double rate) {
    for (int i = 0; i < years; i++) {
        amount *= (1 + rate);
    }
    return amount;
} 
 Time Complexity: O(n)
 Space Complexity: O(1) — no stack usage
 Safe for large n



