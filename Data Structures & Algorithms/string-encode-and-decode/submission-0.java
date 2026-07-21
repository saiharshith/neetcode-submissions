class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str:strs){
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        } 

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> answer= new ArrayList<>();
        int i=0,j,length;

        while(i<str.length()){
            j=i;

            while(str.charAt(j)!='#'){
                j++;                
            }
            length=Integer.parseInt(str.substring(i,j));

            answer.add(str.substring(j+1,j+1+length));
            i=j+1+length;    
        }

        return answer;

    }
}
