# This is a sample PBS script. It will request 1 processor on 1 node
# for 4 hours.
#   
#   Request 5 processors on 5 node 
#   
#PBS -l nodes=1:ppn=8
#
#   Request 4 hours of walltime
#
#PBS -l walltime=24:00:00
#
#   Request 1 gigabyte of memory per process
#
#PBS -l pmem=15gb
#
#   Request that regular output and terminal output go to the same file
#
#PBS -j oe


# Where to write stderr:
#PBS -e neuralArry.err
 
# Where to write stdout: 
#PBS -o neuralArry.out
#
#   The following is the body of the script. By default,
#   PBS scripts execute in your home directory, not the
#   directory from which they were submitted. The following
#   line places you in the directory from which the job
#   was submitted.
#
cd $PBS_O_WORKDIR
#
#   Now we want to run the program "hello".  "hello" is in
#   the directory that this script is being submitted from,
#   $PBS_O_WORKDIR.
#

echo "Job started on `hostname` at `date`"
java repleceCategoriesNam


echo " "
echo "Job Ended at `date`"
echo " "