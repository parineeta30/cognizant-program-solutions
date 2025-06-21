
#  E-Commerce Platform: Product Search Function

Scenario: 
You are working on the search functionality of an e-commerce platform. The search needs to be optimized for fast performance.


# 1. Understanding Asymptotic Notation
# What is Big O Notation?

Big O notation is a mathematical concept used to describe the performance (time or space complexity) of an algorithm as the input size grows. It helps us estimate how scalable or efficient an algorithm is,calculates the upper bound of an algorithm .

| Notation | Meaning                                |
|----------|-----------------------------------------|
| O(1)     | Constant time – fastest possible        |
| O(n)     | Linear time – time grows with input size |
| O(log n) | Logarithmic time – much faster than linear |

# Search Operation Complexity

| Algorithm       | Best Case | Average Case | Worst Case |
|-----------------|-----------|--------------|------------|
| **Linear Search**  | O(1)       | O(n)         | O(n)       |
| **Binary Search**  | O(1)       | O(log n)     | O(log n)   |

- **Best Case**: The item is found at the beginning (Linear) or middle (Binary)
- **Average Case**: The item is somewhere randomly located
- **Worst Case**: The item is at the end or not found at all


# 2. Setup

A simple `Product` class is defined with the following attributes:

```
String productID;
String productName;
String category;
```

These attributes are used as the basis for searching.

---

## ✅ 3. Implementation

### 🔹 Linear Search

- Searches each product one-by-one until a match is found.
- Implemented in `ProductLinearSearch.java`.

### 🔹 Binary Search

- Requires the array to be *sorted by product name*.
- Sorting is done manually (without using Java’s built-in libraries).
- Binary search is then performed.
- Implemented in `ProductBinarySearch.java`.

### 🔹 Data Storage

- Both algorithms use the same `Product[]` array.
- Binary search sorts the array *before searching*.

---

## ✅ 4. Analysis: Linear vs Binary Search

# Linear Search - suitable for my e-commerce platform when the array size is not large
 Simple to implement — just iterate over the array.

 Slower for large data sets because it checks each element one by one.

 Does not require the array to be sorted.

 Best case: When the element is at the beginning of the array (O(1)).

 Worst case: When the element is at the end or not present at all (O(n)).

 Useful when:

The data is unsorted.

The array size is small.

Simplicity is preferred over performance.

# Binary Search - suitable for large e-commerce platform 
 Requires the array to be sorted before searching.

 Much faster for large data sets because it divides the array in half at every step (O(log n)).

 Slightly more complex to implement than linear search.

Performs best when:

The array is large.

The data does not change frequently (so sorting once is worth it).

---

# Output Verification

- Screenshots of console output and code were taken during testing in a **local practice folder**.
  
> *Note: Screenshots and results reflect accurate working behavior, even if directory paths differ.*

---


