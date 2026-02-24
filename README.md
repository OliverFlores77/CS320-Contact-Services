## Reflection

---

## How can I ensure that my code, code, program, or software is functional and secure?

Throughout this course, I learned that ensuring functionality and security starts with thorough testing. I used JUnit 5 to write unit tests that verified each requirement. For example, in my Appointment Service, I tested for null inputs, boundary conditions (like IDs longer than 10 characters), and proper error handling. Using Eclipse's coverage tool helped me confirm that my tests were actually exercising the code, with Task.java reaching 100% coverage. This approach catches bugs early and ensures the code behaves as expected even when users input invalid data.

---
## How do I interpret user needs and incorporate them into a program?

The key for me was going through each requirement line by line and asking "how would I test this?" For the Appointment Service, the requirements stated that appointment dates couldn't be in the past. I interpreted this as a user need for scheduling accuracy, so I built validation right into the constructor and wrote tests using both past and future dates. Each requirement became a test case first, which forced me to really understand what the user needed before writing the actual code.

---

## How do I approach designing software?

I learned to design with testing in mind from the start. I kept validation logic in the object classes themselves (like Appointment.java) so the service classes didn't have to worry about checking lengths or nulls. I used simple, focused methods that do one thing well, and I made sure error messages were helpful instead of generic. Using @BeforeEach to set up fresh service objects for each test kept my tests isolated and reliable. This approach of writing testable code from the beginning saved me time and made debugging much easier.
