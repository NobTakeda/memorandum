import java.util.*;

public class GoalDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mapHeight=sc.nextInt();
        int mapWidth=sc.nextInt();
        int goalPointNum=sc.nextInt();sc.nextLine();
        char[][] mapData=new char[mapHeight][mapWidth];
        
        for(int i=0;i<mapHeight;i++){
            String data=sc.nextLine();
            mapData[i]=data.toCharArray();
        }
        //現在地の座標をとる
        int currentRow=0;
        int currentColumn=0;
        //Mapにゴールポイントの番号をkeyとして、値に(row,column)を格納
        Map<Integer,List<Integer>> goalPointMap = new HashMap<>();
        
        for(int i=0;i<mapData.length;i++){
            for(int j=0;j<mapData[i].length;j++){
                if(mapData[i][j] == 'N'){
                    currentRow=i;
                    currentColumn=j;
                }else if(mapData[i][j] != '#'){
                    int pointNum=Character.getNumericValue(mapData[i][j]);
                    List<Integer> location=new ArrayList<>();
                    location.add(i);
                    location.add(j);
                    goalPointMap.put(pointNum,location);
                }
            }
        }
        
        int minDistance=mapHeight+mapWidth-2;
        Map<Integer,Integer> distanceMap=new HashMap<>();
        
        for(int i=0;i<goalPointNum;i++){
            int distance=0;
            int rowDistance=0;
            int columnDistance=0;
            if((currentRow - goalPointMap.get(i+1).get(0)) < 0){
                rowDistance=(-1)*(currentRow - goalPointMap.get(i+1).get(0));
            }else{
                rowDistance=currentRow - goalPointMap.get(i+1).get(0);
            }
            if((currentColumn - goalPointMap.get(i+1).get(1)) < 0){
                columnDistance=(-1)*(currentColumn - goalPointMap.get(i+1).get(1));
            }else{
                columnDistance=currentColumn - goalPointMap.get(i+1).get(1);
            }
            distance=rowDistance+columnDistance;
            if(minDistance>distance){
                minDistance=distance;
            }
            //distanceMapにゴールポイントの番号をkeyとして距離を格納
            int point=0;
            List<Integer> goalNum=new ArrayList<>();
            for(Integer key : goalPointMap.keySet()){
                goalNum.add(key);
            }
            distanceMap.put(goalNum.get(i),distance);
        }
        
        //distanceMapをkey（ゴールポイントの番号）順にソート
        Object[] mapkey = distanceMap.keySet().toArray();
        Arrays.sort(mapkey);
        int neargoalPoint=0;
        for(int i=0;i<goalPointNum;i++){
            if(minDistance==distanceMap.get(i+1)){
                neargoalPoint++;
            }
        }
        System.out.println(neargoalPoint);
        
        List<Integer> nearPoint=new ArrayList<>();
        for(Integer key: distanceMap.keySet()){
            nearPoint.add(key);
        }
        for(int i=0;i<goalPointNum;i++){
            if(minDistance==distanceMap.get(i+1)){
                System.out.println(nearPoint.get(i));
            }
        }
    }
}
