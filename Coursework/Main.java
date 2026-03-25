package Coursework;


/**
 * Write a description of class Main here.
 *
 * @author (Aayush Joshi)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args)
    {
        // Personal Plan
        PersonalPlan personal = new PersonalPlan("AI-Reinforced Mini", 500, 70, 32000 , 500);
        System.out.println(personal.display());
        System.out.println(personal.purchasePrompts(50));
        System.out.println(personal.usePrompt("Why choose AI-Reinforced Mini?", 200));
        System.out.println("--------------------------");

        // Pro Plan
        ProPlan pro = new ProPlan("AI-Reinforced Pro", 5000, 175, 128000, 5);
        System.out.println(pro.display());
        System.out.println(pro.addTeamMember("Ayaan"));
        System.out.println(pro.removeTeamMember("Zoya"));
        System.out.println(pro.usePrompt("Why choose AI-Reinforced Pro?", 200));
    }
}