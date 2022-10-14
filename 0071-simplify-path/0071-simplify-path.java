class Solution {
    public String simplifyPath(String path) 
    {
        String[] each = path.split("/");
        
        int len = each.length;
        int skip = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=len-1;i>=0;i--)
        {
            if(each[i].equals(".") || each[i].length()==0)
                continue;
            if(each[i].equals(".."))
                skip++;
            else if(skip > 0)
                skip--;
            else
                sb.insert(0,"/"+each[i]);
        }
        if(sb.length()==0) 
            sb.append("/");
        return sb.toString();
    }
}