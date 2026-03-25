package Week_16;


/**
 * Write a description of class CensusProcessor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CensusProcessor
{
    public static Student[] parseCSV(String[] csvData)
    {
        Student[] students=new Student[csvData.length-1];
        for(int i=1;i<csvData.length;i++)
        {
            String[] infoSplit=csvData[i].split(",");
            String name=infoSplit[0].trim();
            int age=Integer.parseInt(infoSplit[1].trim());
            String school=infoSplit[2].trim();
            int grade=Integer.parseInt(infoSplit[3].trim());
            String citizenship=infoSplit[4].trim();
            String phone=infoSplit[5].trim();
            students[i-1]=new Student(name,age,school,grade,citizenship,phone);
        }
        return students;
    }
    public static boolean isValidCitizenship(String cit) {

        if (cit.length() != 10)
        {
            return false;
        }

        if (cit.charAt(2) != '-')
        {
            return false;
        }

        for (int i = 0; i < cit.length(); i++) {

            if (i == 2) continue;

            if (!Character.isDigit(cit.charAt(i)))
                return false;
        }

        return true;
    }
    public static Student[] findBySchool(Student[] students,String school)
    {
        int count=0;
        for(Student val: students)
        {
            if(val.getSchool().equalsIgnoreCase(school))
            {
            count++;
        }
    }
        Student[] result = new Student[count];
        int index = 0;
        for (Student val:students) {
        if (val.getSchool().equalsIgnoreCase(school)) {
            result[index] = val;
            index++;
        }
    }

    return result;
    }
    public static int countByGrade(Student[] students, int grade)
    {
        
        int count=0;
        for(Student val:students)
        {
            if(val.getGrade()==grade)
            {
            count++;
        }
        }
        return count;
    }
    
     public static double averageAge(Student[] students) {
        int total = 0;
        for (Student s : students) {
            total += s.getAge();
        }
        return (double) total / students.length;
    }

    public static Student findLongestName(Student[] students) {
        Student longest = students[0];
        for (Student s : students) {
            if (s.getName().length() > longest.getName().length()) {
                longest = s;
            }
        }
        return longest;
    }
    
    public static String generateCensusReport(Student[] students) {
        StringBuilder report=new StringBuilder();
        int valid=0;
        int invalid=0;
        for(Student val:students)
        {
            boolean isValid=isValidCitizenship(val.getCitizenship());
            if(isValid)
            {
                valid++;
            }
            else
            {
                invalid++;
            }
        }   
        report.append("===== Nepal School Census Report =====\n");
        report.append("Total studnets:").append(students.length).append(" ").append("Valid records:").append(valid).append(" ")
        .append("Invalid records:").append(invalid).append("\n");   
        report.append("-- Student List --\n");
        for(Student val:students)
        {
            boolean isValid=isValidCitizenship(val.getCitizenship());
            if(isValid)
            {
                valid++;
            }
            else
            {
                invalid++;
            }
            report.append(String.format("%6s|%20s|%2d|%2d|%7s|\n",val.getNameInitials(),val.getName(),val.getAge(),val.getGrade(),
            isValid ? "Valid":"Invalid"));
        }
        report.append("-- Statistics --\n");
        report.append("Average age:").append(averageAge(students)).append("\n");
        report.append("Longest Name: ").append(findLongestName(students).getName()).append(" "+"(")
        .append(findLongestName(students).getName().length()).append(" "+"chars)").append("\n");
        report.append("Itahari Int. College:").append(findBySchool(students,"Itahari Int. College").length).append("\n");
        report.append("ICK College:").append(findBySchool(students,"ICK College").length).append("\n");
        report.append("ICP College:").append(findBySchool(students,"ICP College").length);
        return report.toString();
    }
}