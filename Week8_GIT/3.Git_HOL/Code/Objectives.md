# Objectives

- **Explain branching and merging**  
  Branching allows you to create an independent line of development within a repository. A branch is a lightweight pointer to a series of commits. By default, Git repositories start with a single branch (often named `main` or `master`). Creating new branches enables you to work on features, bug fixes, or experiments in isolation without affecting the main codebase.  
  Merging is the process of integrating changes from one branch into another. When a feature branch is ready, you merge it back into the main branch to incorporate its commits. Git provides different merge strategies (e.g., fast-forward, recursive) and will automatically detect and help resolve conflicts when the same file has been modified in both branches.

- **Explain about creating a branch request in GitLab**  
  In GitLab, to propose a new branch for collaboration, you typically:  
  1. Navigate to your project, click **Repository > Branches**, and then **New branch**.  
  2. Enter a name for your branch (e.g., `feature/login-form`) and choose the base branch from which it is created (e.g., `main`).  
  3. Click **Create branch**.  
  This branch now appears in **Repository > Branches** and can be pushed to and worked on by team members.

- **Explain about creating a merge request in GitLab**  
  A Merge Request (MR) in GitLab is how you propose merging one branch into another (e.g., `feature/login-form` into `main`). To create an MR:  
  1. Navigate to **Merge Requests** in the left sidebar and click **New merge request**.  
  2. Select the source branch (your feature branch) and the target branch (e.g., `main`), then click **Compare branches and continue**.  
  3. Fill in the title and description, assign reviewers, add labels or milestones, and optionally set up pipelines or approvals.  
  4. Click **Create merge request**.  
  Team members can review code, discuss changes in comments, and once approved, click **Merge** to integrate the feature branch into the target branch.  
