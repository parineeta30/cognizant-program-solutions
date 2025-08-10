## Objectives
 
· Explain how to clean up and push back to remote Git : 

After resolving conflicts or making changes locally in Git, it is important to clean up your workspace and push your changes back to the remote repository. Follow these steps:

Check the Status: Use git status to see which files are staged, modified, or untracked. This helps confirm that you have resolved conflicts and are ready to commit.

Stage the Changes: Use git add <filename> for specific files or git add . to stage all changed files. This marks the files as ready for committing.

Commit the Changes: Run git commit -m "Your descriptive commit message" to save your changes to the local repository.

Clean Up Unwanted Files: If you have backup or temporary files, add their patterns to .gitignore to avoid pushing them. Commit the .gitignore changes if necessary.

Push to Remote: Use git push origin <branch> to upload your local commits to the corresponding remote branch on the server (like GitHub).

Verify Push: Optionally, check your remote repository (GitHub or GitLab) to confirm that your changes have been successfully pushed.

Summary of Commands:
git status                   # Check current state
git add .                    # Stage all changes
git commit -m "Commit msg"  # Commit changes locally
git push origin branch_name  # Push changes to remote repository