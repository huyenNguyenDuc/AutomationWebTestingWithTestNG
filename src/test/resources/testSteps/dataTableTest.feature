
Feature: Data table
  @Smoke
    Scenario: Single row with no header
      Given I have the book below on the book store
        | The Devil in the White City          | Erik Larson |

    Scenario: Multiple rows with no header
      Given I have the books below on the book store
        | The Devil in the White City          | Erik Larson |
        | The Lion, the Witch and the Wardrobe | C.S. Lewis  |

    Scenario: Single row with header
      Given I have the details of the book on the book store as below
        | book name                            | author      |
        | The Lion, the Witch and the Wardrobe | C.S. Lewis  |

    Scenario: Multiple rows with header
      Given I have the details of the books on the book store as below
        | book name                            | author      |
        | The Devil in the White City          | Erik Larson |
        | The Lion, the Witch and the Wardrobe | C.S. Lewis  |

    Scenario: Single column with no header
      Given I have the book on the book store as below column
        | The Devil in the White City |
        | Erik Larson                 |

    Scenario: Single column with header
      Given I have the book and its detail on the book store as below columns
        | book name | The Devil in the White City |
        | author    | Erik Larson                 |

    Scenario: Single column with no header and convert to row, use @Transpose
      Given I have the book as below column
        | The Devil in the White City |
        | Erik Larson                 |

    Scenario: Single column with header and use domain object and data table type
      Given I have the book and its detail as below columns
        | book name | The Devil in the White City |
        | author    | Erik Larson                 |

  Scenario: Test the data table must be the last argument
    Given draft 1 test
      | book name | The Devil in the White City |
      | author    | Erik Larson                 |

  Scenario: Multiple columns with header
    Given I have the books and its detail on the book store as below columns
      | book name | The Devil in the White City | The Lion, the Witch and the Wardrobe |
      | author    | Erik Larson                 | C.S. Lewis                           |