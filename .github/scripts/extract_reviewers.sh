#!/bin/bash

CODEOWNERS_FILE=".github/CODEOWNERS"
CHANGED_FILES=$(git diff --name-only origin/main...HEAD)

REVIEWERS=()

# Extract reviewers for changed files
while IFS= read -r file; do
    while IFS= read -r line; do
        if [[ "$file" == ${line%% *}* ]]; then
            reviewers=$(echo "$line" | awk '{for (i=2; i<=NF; i++) print $i}')
            for reviewer in $reviewers; do
                [[ ! " ${REVIEWERS[@]} " =~ " $reviewer " ]] && REVIEWERS+=("$reviewer")
            done
        fi
    done < "$CODEOWNERS_FILE"
done <<< "$CHANGED_FILES"

# Ensure at least two reviewers
if [[ ${#REVIEWERS[@]} -lt 2 ]]; then
    echo "❌ Error: At least two reviewers are required."
    exit 1
fi

# Save reviewers to a file
echo "${REVIEWERS[@]}" > .github/reviewers.txt
echo "✅ Reviewers: ${REVIEWERS[@]}"
