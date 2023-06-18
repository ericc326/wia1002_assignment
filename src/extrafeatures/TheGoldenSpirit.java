/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extrafeatures;

/**
 *
 * @author firdausazman
 */import java.util.*;

public class TheGoldenSpirit {
    private static HashMap<String, List<String>> familyTree = new HashMap<>();

    public static void main(String[] args) {
        // Build the family tree
        buildFamilyTree();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the first Joestar: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter the name of the second Joestar: ");
        String name2 = scanner.nextLine();

        String lowestCommonAncestor = findLowestCommonAncestor(name1, name2);

        if (name1.equals("George Joestar II")||name2.equals("George Joestar II") && lowestCommonAncestor.equals("Jonathan Joestar")) {
            lowestCommonAncestor += " and Erina Joestar";
        }
        else if(name1.equals("Jonathan Joestar")||name2.equals("Jonathan Joestar") && lowestCommonAncestor.equals("George Joestar I")) {
            lowestCommonAncestor += " and Mary Joestar";
        }
        else if (name1.equals("Joseph Joestar")||name2.equals("Joseph Joestar") && lowestCommonAncestor.equals("George Joestar II")) {
            lowestCommonAncestor += " and Lisa Lisa";
        }
        else if(name1.equals("Holy Kujo")||name2.equals("Holy Kujo") && lowestCommonAncestor.equals("Joseph Joestar")) {
            lowestCommonAncestor += " and Suzi Q.";
        }
        else if(name1.equals("Jotaro Kujo")||name2.equals("Jotaro Kujo") && lowestCommonAncestor.equals("Holy Kujo")) {
            lowestCommonAncestor += " and Sadao Kujo";
        }

        System.out.println("======================================================================");
        System.out.println("Lowest Common Ancestor of " + name1 + " and " + name2 + ":");
        System.out.println(lowestCommonAncestor);
        System.out.println("======================================================================");
    }

    public static void buildFamilyTree() {
        familyTree.put("Jonathan Joestar", Arrays.asList("George Joestar I", "Mary Joestar"));
        familyTree.put("George Joestar II", Arrays.asList("Jonathan Joestar", "Erina Joestar"));
        familyTree.put("Giorno Giovanna", Arrays.asList("Jonathan Joestar", "DIO"));
        familyTree.put("Joseph Joestar", Arrays.asList("George Joestar II", "Lisa Lisa"));
        familyTree.put("Holy Kujo", Arrays.asList("Joseph Joestar", "Suzi Q."));
        familyTree.put("Josuke Higashikata", Arrays.asList("Joseph Joestar", "Tomoko Higashikata"));
        familyTree.put("Jotaro Kujo", Arrays.asList("Holy Kujo", "Sadao Kujo"));
        familyTree.put("Jolyne Cujoh", Arrays.asList("Jotaro Kujo", null));
        // Add other individuals and their parents' information here...
    }

    public static String findLowestCommonAncestor(String joestar1, String joestar2) {
        List<String> ancestors1 = findAncestors(joestar1);
        List<String> ancestors2 = findAncestors(joestar2);

        for (String ancestor : ancestors1) {
            if (ancestors2.contains(ancestor)) {
                return ancestor;
            }
        }

        return "No common ancestor found";
    }

    private static List<String> findAncestors(String joestar) {
        List<String> ancestors = new ArrayList<>();
        findAncestorsRecursive(joestar, ancestors);
        return ancestors;
    }

    private static void findAncestorsRecursive(String joestar, List<String> ancestors) {
        if (familyTree.containsKey(joestar)) {
            List<String> parents = familyTree.get(joestar);
            for (String parent : parents) {
                if (parent != null && !ancestors.contains(parent)) {
                    ancestors.add(parent);
                    findAncestorsRecursive(parent, ancestors);
                }
            }
        }
    }
}










//Jotaro Kujo Jolyne Cujoh




