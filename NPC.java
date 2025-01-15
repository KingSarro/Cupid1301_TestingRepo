public class NPC{

    //Basic Attributes
    private String name;
    private int id;
    //Character Attributes
    ////private String[] personalityTypes;
    private int[] personalityValues = new int[PersonalityType.values().length];
    private int[] temperamentValues = new int[TemperamentType.values().length];
    ////private String[] hobbyType;
    private int[] hobbyVales  = new int[HobbyType.values().length]; //A suggestion was having an array for the description of hobbies

    private PersonalityType[] highPersonalityTypes = new PersonalityType[2];
    //private HobbyType[] highHobbyTypes = new HobbyType[2];

    public NPC(String name, int id){
        this.name = name;
        this.id = id;
        GeneratePersonality();
        GenerateTemperaments();
    }

    private void GeneratePersonality(){
        //Randomly generate personality traits
        int personalityCount = PersonalityType.values().length;
        ////System.out.println("Debug: personality count = " + personalityCount);
        //This will pick a random number from 1 to n (representing personality count)
        for(int i = 0; i < personalityCount;){
            //Pick a random personality trait, but only if the value at that index is 0.
            int r = (int) (Math.random() * personalityCount);
            if(personalityValues[r] == 0){
                personalityValues[r] = personalityCount - i;


                //If the array has less than 2 unique values, add the remaining unique values to the highPersonalityTypes array.
                if(i < 2){
                    highPersonalityTypes[i] = PersonalityType.values()[r];
                }
                
                i++;

                //if()
            }
        }
    }
    private void GenerateTemperaments(){
        //Randomly generate personality traits
        int temperamentCount = TemperamentType.values().length;
    
        //This will pick a random number from 1 to n, each loop descending in value;
        for(int i = 0; i < temperamentCount;){
            //Pick a random number from 0 to temperamentCount-1, but only if the value at that index is 0.
            int r = (int) (Math.random() * temperamentCount);
            if(temperamentValues[r] == 0){
                temperamentValues[r] = temperamentCount - i;
                i++;
            }  
        }
    }
    


    public void SetName(String npcName){
        name = npcName;
    }
    public void SetId(int idNum){
        id = idNum;
    }

    public String GetName(){
        return name;
    }
    public int GetId(){
        return id;
    }
    public int[] GetPersonalityValues(){
        return personalityValues;
    }
    public int[] GetTemperamentValues(){
        return temperamentValues;
    }
    public PersonalityType[] GetHighPersonalityTypes(){
        return highPersonalityTypes;
    }



    public void DisplayNPCInfo(){
        //Display the NPC's information
        System.out.println("This is NPC: " + name + ", ID: " + id);
        System.out.println("Personality Traits: " + highPersonalityTypes[0].name() + ", " + highPersonalityTypes[1].name());
        for(int i = 0; i < temperamentValues.length; i++){
            System.out.println(TemperamentType.values()[i].name() + ": " + temperamentValues[i]);
        }
    }

}