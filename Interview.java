public class Interview {

    public String firstName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String reverseString(String str) {
        char[] chars = str.toCharArray();
        int beginning=0;
        int end = str.length() -1;
        while(beginning < end){
            swap(chars, beginning, end);
            beginning++;
            end--;
        }

        return new String(chars);

        // if(str.isEmpty()) {
        //     return str;
        // } else {
        //     // Calling Function Recursively, and adding the last character to the beginning of the string, and removing the last character
        //     return reverseString(str.substring(1)) + str.charAt(0);
        // }
    }

    public void swap(char[] chars, int from, int to){
        char t = chars[to];
        chars[to] = chars[from];
        chars[from] = t;
    }
    

    public static void main(String[] args) {
        Interview interview = new Interview();
        interview.setFirstName("John");
        System.out.println(interview.getFirstName());
        System.out.println(interview.reverseString("John"));
    }
    
}
