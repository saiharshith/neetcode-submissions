class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> required = new HashMap<>();

        for(int i=0;i<t.length();i++){
            required.put(t.charAt(i),required.getOrDefault(t.charAt(i),0)+1);
        }

        int target = required.size(), count=0;

        HashMap<Character,Integer> current = new HashMap<>();

        int left=0,right=0;
        int min = s.length()+1;

        String minString = "";
        
        while(right<s.length()){
            current.put(s.charAt(right),current.getOrDefault(s.charAt(right),0)+1);
            if(required.containsKey(s.charAt(right)) && required.get(s.charAt(right)).equals(current.get(s.charAt(right)))){
                count++;
            }
            
            while(count==target && left<=right){
                if(min>right-left+1){
                    min=right-left+1;
                    minString = s.substring(left,right+1);
                }
                    

            if(required.containsKey(s.charAt(left)) && current.get(s.charAt(left)).equals(required.get(s.charAt(left))))
            count--;    current.put(s.charAt(left),current.get(s.charAt(left))-1);
            left++;    
            }
        right++;
        }

        return minString;    
    }
}
