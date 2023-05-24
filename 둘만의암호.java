public class 둘만의암호 {
    public static Character change(Character c, int num){
        int i = num % 26;
        if(c + i >= 123){
            return (char)((c+i) % 123 + 97) ;
        }
        return (char)(c+i);
    }

    public String solution(String s, String skip, int index) {
        StringBuffer answer = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            int idx = 1;
            int count = 0;
            while(count < index){
                Character uni = change(c, idx);
                if(!skip.contains(String.valueOf(uni))) {count +=1;}
                idx +=1;
            }
            idx-=1;
            Character uni = change(c, idx);
            answer.append(uni);
        }

        return answer.toString();
    }
}
