# 422-Project
Initial Repo for the 422 Project Deliverables.


# Deliverable 1
ACheck contains the Halstead Length check where it checks for the total of operators and operands.
BCheck contains the comment count checker, where it reports the number of comments in the file.

# Delivareable 2
Same as above, but now with tests associated with them.
ACheck(Halstead Length) is associated with "HalsteadLengthTest.java"
BCheck(NumberOfCommentsCheck) is associated with "NumberOfCommentsCheckTest.java"

# Deliverable 3

Halstead Checks:

Halstead Length: The sum of total number of operators and operands. When a token is visited it is associated with one of these. Then a counter increases by one, and one the tree is done, we report the count.
Halstead Vocabulary: The sum of unique operators with unique operands. This was aschieved through the use of HashSets, which allowed for adding each time a token was visited and it would get added to the Set, since sets do not allow for duplicates, it allows us to just get the size of the set at the end and get our result.
Halstead Volume: Reports the volume in terms of: Halstead Length * Log_2(unique tokesn). unique tokesn gets measured by using a set.
Halstead Difficulty: reports the halstead difficulty with the following equation: [(unique_operators / 2) * total_operands ] / unique_operands
Halstead Effort: Halstead_Difficulty * Halstead_Volume. Effort = D*V. It represents a suggestion for how long a code review might take.

All Halstead Checks used the following arrays for their tokens:

    
                    TokenTypes.CHAR_LITERAL,
                    TokenTypes.NUM_INT,
                    TokenTypes.NUM_LONG,
                    TokenTypes.NUM_FLOAT,
                    TokenTypes.NUM_DOUBLE,
                    TokenTypes.STRING_LITERAL,
                    TokenTypes.ASSIGN,
                    TokenTypes.DIV_ASSIGN,
                    TokenTypes.DIV,
                    TokenTypes.DOT,
                    TokenTypes.EQUAL,
                    TokenTypes.GE,
                    TokenTypes.INC,
                    TokenTypes.INDEX_OP,
                    TokenTypes.LAND,
                    TokenTypes.LE,
                    TokenTypes.LITERAL_INSTANCEOF,
                    TokenTypes.LITERAL_VOID,
                    TokenTypes.LITERAL_BOOLEAN,
                    TokenTypes.LITERAL_BYTE,
                    TokenTypes.LITERAL_CHAR,
                    TokenTypes.LITERAL_SHORT,
                    TokenTypes.LITERAL_INT,
                    TokenTypes.LITERAL_LONG,
                    TokenTypes.LITERAL_FLOAT,
                    TokenTypes.LITERAL_DOUBLE,
                    TokenTypes.LITERAL_PRIVATE,
                    TokenTypes.LITERAL_PUBLIC,
                    TokenTypes.LITERAL_PROTECTED,
                    TokenTypes.LITERAL_STATIC,
                    TokenTypes.LITERAL_TRANSIENT,
                    TokenTypes.LITERAL_NATIVE,
                    TokenTypes.LITERAL_SYNCHRONIZED,
                    TokenTypes.LITERAL_VOLATILE,
                    TokenTypes.LITERAL_CLASS,
                    TokenTypes.LITERAL_INTERFACE,
                    TokenTypes.LITERAL_THIS,
                    TokenTypes.LITERAL_SUPER,
                    TokenTypes.LITERAL_FOR,
                    TokenTypes.LITERAL_WHILE,
                    TokenTypes.LITERAL_DO,
                    TokenTypes.DO_WHILE,
                    TokenTypes.LITERAL_BREAK,
                    TokenTypes.LITERAL_CONTINUE,
                    TokenTypes.LITERAL_RETURN,
                    TokenTypes.LITERAL_FINALLY,
                    TokenTypes.LITERAL_CATCH,
                    TokenTypes.LNOT,
                    TokenTypes.LOR,
                    TokenTypes.LT,
                    TokenTypes.MINUS,
                    TokenTypes.MOD,
                    TokenTypes.MOD_ASSIGN,
                    TokenTypes.NOT_EQUAL,
                    TokenTypes.PLUS,
                    TokenTypes.PLUS_ASSIGN,
                    TokenTypes.POST_DEC,
                    TokenTypes.POST_INC,
                    TokenTypes.QUESTION,
                    TokenTypes.STAR,
                    TokenTypes.STAR_ASSIGN,
                    TokenTypes.UNARY_MINUS,
                    TokenTypes.UNARY_PLUS,
                    TokenTypes.RBRACK,
                    TokenTypes.RCURLY,
                    TokenTypes.VARIABLE_DEF,
                    TokenTypes.METHOD_REF,
                    TokenTypes.BNOT,
                    TokenTypes.BOR,
                    TokenTypes.COLON,
                    TokenTypes.COMMA,
                    TokenTypes.GT,
                    TokenTypes.INC,
                    TokenTypes.DEC,
                    TokenTypes.LITERAL_TRUE,
                    TokenTypes.LITERAL_FALSE,
                    TokenTypes.LITERAL_NULL,
                    TokenTypes.MODIFIERS,
                    TokenTypes.VARIABLE_DEF,
                    TokenTypes.METHOD_CALL,
                    TokenTypes.EXPR,
                    TokenTypes.ARRAY_INIT,
                    TokenTypes.FOR_INIT,
                    TokenTypes.FOR_CONDITION,
                    TokenTypes.FOR_ITERATOR,
                    TokenTypes.FINAL,
                    TokenTypes.ABSTRACT,
                    TokenTypes.PATTERN_VARIABLE_DEF,
                    TokenTypes.PARAMETER_DEF,
                    TokenTypes.PARAMETERS
                    
Operands were counted as the following:

                    TokenTypes.CHAR_LITERAL,
                    TokenTypes.NUM_INT,
                    TokenTypes.NUM_LONG,
                    TokenTypes.NUM_FLOAT,
                    TokenTypes.NUM_DOUBLE,
                    TokenTypes.STRING_LITERAL,
                    TokenTypes.PATTERN_VARIABLE_DEF,
                    TokenTypes.PARAMETER_DEF,
                    TokenTypes.PARAMETERS,
                    TokenTypes.LITERAL_TRUE,
                    TokenTypes.LITERAL_FALSE,
                    
Operators were everything that was NOT in the operand array.

Normal Checks:

BCheck (Number of Comment Check): Looks at anything that signifies the start of a comment and counts it as +1 for the counter.
CommentLineCountCheck: Counts the number of lines all comments take, this is done by not only looking at the beginning of the comment but also the body and ending.
LoopStatementCountCheck: Counts the number of loops in a file, for loops, while loops, do_while loops.
OperandCountcheck: Counts the number of operands
OperatorCountCheck: Counts the number of operators
ExpressionCountCheck: Counts the number of expressions: 2+2
CastCountcheck: counts the number of Typecast operations: (double)3;


