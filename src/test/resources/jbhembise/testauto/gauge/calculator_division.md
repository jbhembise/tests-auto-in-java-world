# Calculator division tests
Test samples :

| n1 | n2 | expected |  
|----|----|----------|  
| 9  | 3  | 3        |
| 30 | 5  | 6        |
  
## Division of two numbers (data driven testing)
 * Given a calculator exists
 * When i divide <n1> by <n2>
 * Then it should return <expected>
 
## Division by zero
 * Given a calculator exists
 * When i divide "10" by "0"
 * Then it should throw an exception