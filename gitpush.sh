# Check if a commit message is provided
if [ -z "$1" ]; then
  echo "No commit message provided."
  echo "Usage: ./gitpush.sh \"your commit message\""
  exit 1
fi

# Set the commit message from the first argument
COMMIT_MSG="$1"

echo "adding files to git"
git add .
echo "committing files to git"
git commit -m "$COMMIT_MSG"
echo "pushing files to git"
git push
echo "--- ALL PROCESSES COMPLETED ---"
echo "
/$$$$$$                                        
|_  $$_/                                        
  | $$    /$$$$$$$  /$$$$$$   /$$$$$$   /$$$$$$ 
  | $$   /$$_____/ |____  $$ |____  $$ /$$__  $$
  | $$  |  $$$$$$   /$$$$$$$  /$$$$$$$| $$  \ $$
  | $$   \____  $$ /$$__  $$ /$$__  $$| $$  | $$
 /$$$$$$ /$$$$$$$/|  $$$$$$$|  $$$$$$$|  $$$$$$$
|______/|_______/  \_______/ \_______/ \____  $$
                                            | $$
                                            | $$
                                            |_/ 
                                            "
