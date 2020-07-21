public class JavaBug {

    public static void main(String[] args) {
        System.out.println(
                "1024 bytes in si: " + humanByteCount(1024, true) + " 1024 bytes: " + humanByteCount(1024, false));

        System.out.println(
                "2048 bytes in si: " + humanByteCount(2048, true) + " 2048 bytes: " + humanByteCount(2048, false));

        System.out.println(
                "21531 bytes in si: " + humanByteCount(21531, true) + " 21531 bytes: " + humanByteCount(21531, false));

        System.out.println("3000000 bytes in si: " + humanByteCount(3000000, true) + " 3000000 bytes: "
                + humanByteCount(3000000, false));

        System.out.println("36954300 bytes in si: " + humanByteCount(36954300, true) + " 36954300 bytes: "
                + humanByteCount(36954300, false));

        System.out.println(Long.MAX_VALUE + " bytes in si: " + humanByteCount(Long.MAX_VALUE, true) + " "
                + Long.MAX_VALUE + " bytes: " + humanByteCount(Long.MAX_VALUE, false));
    }

    private static String[] prefix = new String[] { "", "K", "M", "G", "T", "P", "E" };

    public static String humanByteCount(long bytes, boolean si) {
        if (bytes == 0)
            return "0 B";

        // the bug was here with the unit. for si the unit is 1024 otherwise it should be 1000
        int unit = !si ? 1000 : 1024;
        double power = Math.min(Math.floor(Math.log(bytes) / Math.log(unit)), 6);
        String pref = prefix[(int) power] + (si && power > 0 ? "iB" : "B");
        String format = power == 0 ? "%.0f %s" : "%.1f %s";

        return String.format(format, bytes / Math.pow(unit, power), pref);
    }
}
