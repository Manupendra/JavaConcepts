public class StringVSStringBufferVSStringBuilder {
    public static void main(String[] args) {
        String s1 = "Manu";
        String s2 = "Manu";
        String s3 = new String("Manu");

        System.out.println("s1 and s2 are stored in heap area of \"string constant pool\" " + (s1 == s2));
        System.out.println("s2 is stored in heap area of string constant pool and s3 is stored in heap space " + (s2 == s3));

        /**
         All String are immutable which means once string object created can't be modified
         */

    }

    /*
        String is not thread safe. It is less performant than StringBuffer and StringBuilder. It is not immutable.
     */
    public void concatString(String s1, String s2) {
        for (int i = 0; i < 100000; i++) {
            s2 = s1 + s2;
        }
    }

    /*
        StringBuffer is thread-safe since all methods are implement using synchronized and it is more performant than String.It is immutable.
     */
    public void concatStringBuffer(StringBuffer s1, StringBuffer s2) {
        for (int i = 0; i < 100000; i++) {
            s2 = s2.append(s1);
        }
    }

    /*
        StringBuilder is not thread-safe and it is more performant than both StringBuffer and String. It also an immutable.
     */
    public void concatStringBuilder(StringBuilder s1, StringBuilder s2) {
        for (int i = 0; i < 100000; i++) {
            s2 = s2.append(s1);
        }
    }
}
