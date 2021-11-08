import java.util.*;

public class ImprovedGoalDistance{
	public static void main(String[] args){

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
			//goalPointMapをkeyの昇順にソート
			Object[] mapkey = goalPointMap.keySet().toArray();
			Arrays.sort(mapkey);
				
			int minDistance=mapHeight+mapWidth-2;
			List<Integer> distanceList=new ArrayList<>();
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
				//distanceListにゴールポイントまでの距離を格納
				distanceList.add(distance);
			}   

			int nearGoalPoint=0;
				for(int i=0;i<goalPointNum;i++){
					if(minDistance==distanceList.get(i)){
						nearGoalPoint++;
					}
				}
			System.out.println(nearGoalPoint);
	
			for(int i=0;i<goalPointNum;i++){	
				if(minDistance==distanceList.get(i)){
					System.out.println(i+1);
				}
			}
			/*	
			要素確認用
			for(int i=0;i<distanceList.size();i++){
				System.out.println("ゴール地点"+(i+1)+"からの距離は"+distanceList.get(i));
			}
			for(Integer key: goalPointMap.keySet()){
				System.out.println(key+":"+goalPointMap.get(key));
			}
			*/
		}
}
