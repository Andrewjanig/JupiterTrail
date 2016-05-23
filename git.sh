git config --global user.email "9506047@student.swin.edu.au"
git config --global user.name "samsmyname"
git push origin --delete jenkins-build
git add .
git commit -am "jenkins autobuild"