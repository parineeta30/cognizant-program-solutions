Objectives:
 
·  Explain how to resolve the conflict during merge.


When merging branches in Git, sometimes a conflict can occur if the same part of a file is changed in both branches. To resolve this, follow these steps:

Start the Merge: Use the command git merge branch_name. If there is a conflict, Git will show an error message and mark the conflicted files.

Check Which Files Have Conflicts: Run git status to see the list of files with conflicts.

Open the Conflicted Files: The conflicting parts will be shown with special markers:

<<<<<<< HEAD
Your changes
=======
Changes from the other branch
>>>>>>> branch_name
Resolve the Conflict: Decide which changes to keep. You can keep your changes, the other branch’s changes, or combine both. Remove all the conflict markers after editing.

Mark the Conflict as Resolved: Save the file and use git add filename to stage it.

Finish the Merge: Use git commit to complete the merge process.