# library-tracker
- Student A: Haythem Khalad Alasmar
- Student B: Abd Alfatah Nader Hamdan


## Search and Remove Books

- `searchBooks(keyword)` searches for books by title or part of a title.
- Search is case-insensitive and displays all matching results.
- `removeBook(title)` removes the first book with a matching full title.
- Removal is case-insensitive and saves the updated list to `books.json`.
- Empty input and missing books display clear messages.

These methods can be called from Java code. The current main method
loads and lists saved books.