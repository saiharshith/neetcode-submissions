class Solution {
    static class Car{
        int position, speed;

        Car(int position, int speed){
            this.position = position;
            this.speed = speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Car[] cars = new Car[n];

        for(int i=0;i<n;i++){
            cars[i] = new Car(position[i],speed[i]);
        }

        Arrays.sort(cars,(a,b)->Integer.compare(b.position,a.position));

        int fleets=0; double fleetTime=0;

        for(int i=0;i<n;i++){
            double time = (double)(target-cars[i].position)/(cars[i].speed);

            if(time>fleetTime){
                fleets++;
                fleetTime = time;
            }
        }

        return fleets;
        
    }
}
