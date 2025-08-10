Objectives
 
· Explain git ignore :
.gitignore is a special file that tells Git which files and folders to ignore when tracking changes. This is useful for excluding:

Log files

Temporary files

Build artifacts

Configuration files with sensitive data

IDE-specific files


· Explain how to ignore unwanted files using git ignore:

Step-by-Step: Ignoring Files
Create or Open .gitignore

bash
notepad++ .gitignore
Or:

bash
touch .gitignore
Add Ignore Patterns

# Ignore all log files
*.log

# Ignore log folder
log/

# Ignore operating system files
.DS_Store
Thumbs.db

Verify Ignored Files
## bash
git status --ignored
Ignored files will appear under an “Ignored files” section.

Commit Your .gitignore
## bash
git add .gitignore
git commit -m "Add .gitignore to exclude logs and temporary files"
git push
Untrack Already-Tracked Files (if needed)

## bash
git rm --cached unwanted.file
git commit -m "Stop tracking unwanted.file"
git push