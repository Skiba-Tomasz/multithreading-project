package pl.skibahost;

import mpi.MPI;
import pl.skibahost.file.DictionarySplitter;
import pl.skibahost.file.DictionarySplitterMPJ;
import pl.skibahost.tasks.InvocationType;
import pl.skibahost.tasks.SearchTask;
import pl.skibahost.tasks.SearchTaskType;

import java.util.Arrays;

public class MainMPJ {

    /**
     * First 3 arguments are exclusive to MPJ, the 4th is keyword that will be looked up in dictionary
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        System.out.println("MPJ process args: " + Arrays.toString(args));
        new DictionarySplitterMPJ(Integer.parseInt(args[0]), Integer.parseInt(args[1])).run();
        MPI.Init(args);
        if(args.length < 3)
            System.out.println("Please provide a keyword that will be looked up in dictionary as 4th argument");
        new SearchTask(
                args[3],
                DictionarySplitterMPJ.files.get(0),
                SearchTaskType.MPJ,
                InvocationType.MPJ_CLI,
                AppState.getInstance().delay).run();
        System.out.println(AppState.getInstance().results);
        MPI.Finalize();
    }
} 