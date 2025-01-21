import Enums.Personalities.*;
import java.util.Random;

public class Npc{

    //Basic Attributes
    private String name;
    private int id;
    //Character Attributes
    private EnergyType energy = EnergyType.CALM;
    private PlayfulnessType playfulness = PlayfulnessType.PLAYFUL;
    private AgreeablenessType agreeableness = AgreeablenessType.COOPERATIVE;
    private AssertivenessType assertiveness = AssertivenessType.ASSERTIVE;
    private ResponsibilityType responsibility = ResponsibilityType.RESPONSIBLE;

    public Npc(String name, int id){
        this.name = name;
        this.id = id;

        GeneratePersonality();
    }

    //-------------------------------------------------------------------
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

    public void DisplayInfo(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Energy: " + energy.toString());
        System.out.println("Playfulness: " + playfulness.toString());
        System.out.println("Agreeableness: " + agreeableness.toString());
        System.out.println("Assertiveness: " + assertiveness.toString());
        System.out.println("Responsibility: " + responsibility.toString());
    }

    //---------------------------------------------------------------------------
    private void GeneratePersonality(){
        //Determine personality traits randomly
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        int r = random.nextInt();
        energy = r > 0? EnergyType.ENERGETIC : EnergyType.CALM;
        r = random.nextInt();
        playfulness = r > 0? PlayfulnessType.PLAYFUL : PlayfulnessType.SERIOUS;
        r = random.nextInt();
        agreeableness = r > 0? AgreeablenessType.COOPERATIVE : AgreeablenessType.COMPETITIVE;
        r = random.nextInt();
        assertiveness = r > 0? AssertivenessType.ASSERTIVE : AssertivenessType.PASSIVE;
        r = random.nextInt();
        responsibility = r > 0? ResponsibilityType.RESPONSIBLE : ResponsibilityType.IRRESPONSIBLE;
    }
}