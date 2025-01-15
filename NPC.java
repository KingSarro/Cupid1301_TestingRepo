import Cupid1301_TestingRepo\EnumClasses;

public class NPC{

    //Basic Attributes
    private String name;
    private int id;
    //Character Attributes
    private EnergyType energy;
    private PlayfulnessType playfulness;
    private AgreeablenessType agreeableness;
    private AssertivenessType assertiveness;
    private ResponsibilityType responsibility;

    public NPC(String name, int id){
        this.name = name;
        this.id = id;
        GeneratePersonality();
        //GenerateTemperaments();
    }

    private void GeneratePersonality(){
        //Randomly generate personality traits
        int personalityCount = PersonalityType.values().length;
        // Create an array to hold the personality values.
        int[] personalityValues = new int[personalityCount];
        ////System.out.println("Debug: personality count = " + personalityCount);
        
        //# This loop will pick how intense the personality traits are.
        for(int i = 0; i < personalityCount;){ 
            //Pick a random personality trait, but only if the value at that index is 0.
            int r = (int) (Math.random() * personalityCount);
            if(personalityValues[r] == 0){
                personalityValues[r] = personalityCount - i;
            }
        }

        //#This for loop is used to determine if the personality traits are to the "left" or "right" side of the personality traits.
        for (int i = 0; i < personalityCount; i++){
            int r = (int) Math.random(); // Randomly choose 0 or 1 - 0 = Left, 1 = Right
            if(r == 0){
                personalityValues[i] = -personalityValues[i];
            }
        }

        //This will generate the personality traits based on the generated values
        //region GeneratePersonality
        energy = personalityValues[0] > 0? EnergyType.ENERGETIC : EnergyType.CALM;
        playfulness = personalityValues[1] > 0? PlayfulnessType.PLAYFUL : PlayfulnessType.SERIOUS;
        agreeableness = personalityValues[2] > 0? AgreeablenessType.COOPERATIVE : AgreeablenessType.COMPETITIVE;
        assertiveness = personalityValues[3] > 0? AssertivenessType.ASSERTIVE : AssertivenessType.PASSIVE;
        responsibility = personalityValues[4] > 0? ResponsibilityType.RESPONSIBLE : ResponsibilityType.IRRESPONSIBLE;
        //endregion



        //Sets the personality trait based on the generated values
    }




    
    // private void GenerateTemperaments(){
    //     //Randomly generate personality traits
    //     int temperamentCount = TemperamentType.values().length;
    
    //     //This will pick a random number from 1 to n, each loop descending in value;
    //     for(int i = 0; i < temperamentCount;){
    //         //Pick a random number from 0 to temperamentCount-1, but only if the value at that index is 0.
    //         int r = (int) (Math.random() * temperamentCount);
    //         if(temperamentValues[r] == 0){
    //             temperamentValues[r] = temperamentCount - i;
    //             i++;
    //         }  
    //     }
    // }
    


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
    // public int[] GetPersonalityValues(){
    //     return personalityValues;
    // }
    // public int[] GetTemperamentValues(){
    //     return temperamentValues;
    // }
    // public PersonalityType[] GetHighPersonalityTypes(){
    //     return highPersonalityTypes;
    // }



    public void DisplayNPCInfo(){
        //Display the NPC's information
        System.out.println("This is NPC: " + name + ", ID: " + id);
        //System.out.println("Personality Traits: " + highPersonalityTypes[0].name() + ", " + highPersonalityTypes[1].name());
        System.out.println("Personality Traits: " + energy.name() + ", " + playfulness.name() + ", " + agreeableness.name() + ", " + assertiveness.name() + ", " + responsibility);
        // for(int i = 0; i < temperamentValues.length; i++){
        //     System.out.println(TemperamentType.values()[i].name() + ": " + temperamentValues[i]);
        // }
    }

}