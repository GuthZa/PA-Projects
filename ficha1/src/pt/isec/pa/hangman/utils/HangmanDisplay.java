package pt.isec.pa.hangman.utils;

public class HangmanDisplay {
    private static final String[] HANGMAN_STAGES = {
            //0 errors
            """
                +----------+
                |          |
                |
                |
                |
                |
                |
                |
                |
                ===
            """,
            //1 error
            """
                +----------+
                |          |
                |          O
                |
                |
                |
                |
                |
                |
                ===
            """,
            //2 errors
            """
                +----------+
                |          |
                |          O
                |          +
                |
                |
                |
                |
                |
                ===
            """,
            //3 errors
            """
                +----------+
                |          |
                |          O
                |          +--+
                |
                |
                |
                |
                |
                ===
            """,
            //4 errors
            """
                +----------+
                |          |
                |          O
                |       +--+--+
                |
                |
                |
                |
                |
                ===
            """,
            //5 erros
            """
                +----------+
                |          |
                |          O
                |       +--+--+
                |          |
                |          |
                |
                |
                |
                ===
            """,
            //6 errors
            """
                +----------+
                |          |
                |          O
                |       +--+--+
                |          |
                |          |
                |           \\
                |            \\
                |
                ===
            """,
            //7 errors
            """
                +----------+
                |          |
                |          O
                |       +--+--+
                |          |
                |          |
                |         / \\
                |        /   \\
                |
                ===
            """};

    private HangmanDisplay() {}

    public static int getNumStages() { return HANGMAN_STAGES.length;}

    public static String getStage(int stage) {
        if (stage < 0 || stage > HANGMAN_STAGES.length)
            return null;
        return HANGMAN_STAGES[stage];
    }
}
