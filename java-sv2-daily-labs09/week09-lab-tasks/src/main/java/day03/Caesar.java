package day03;

public class Caesar extends Encryption {

    private final int offset;

    public Caesar(int offset) {
        this.offset = offset % 26;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public String encrypts(String input) {
        char[] out = input.toUpperCase().toCharArray();
        for (int i = 0; i < out.length; i++) {
            out[i] += offset;
            if (out[i] > 'Z')
                out[i] -= 'Z' - 'A' + 1;
        }
        return new String(out);
        //(char)(((input.charAt(i) + offset - 65) % 26) + 65)
    }

    public static void main(String[] args) {
        Caesar caesar = new Caesar(13);
        System.out.println(caesar.encrypts(caesar.encrypts("alma")));
    }
}
