class Solution {
    List<String> answer;
    Map<Character,String> myMap;  
    private void helper(String digits,int index,StringBuilder sb){
        if(index==digits.length()){
            answer.add(sb.toString());
            return;    
        }

        String temp = myMap.get(digits.charAt(index));

        for(int i=0;i<temp.length();i++){
            sb.append(temp.charAt(i));
            helper(digits,index+1,sb);
            sb.deleteCharAt(sb.length()-1);    
        }       
    }
    public List<String> letterCombinations(String digits) {
        answer = new ArrayList<>();
        if(digits.length()==0){
            return answer;
        }
        myMap = new HashMap<>();

        myMap.put('2',"abc");
        myMap.put('3',"def");
        myMap.put('4',"ghi");
        myMap.put('5',"jkl");
        myMap.put('6',"mno");
        myMap.put('7',"pqrs");
        myMap.put('8',"tuv");
        myMap.put('9',"wxyz");

        StringBuilder sb = new StringBuilder();

        helper(digits,0,sb);

        return answer;

    }
}
