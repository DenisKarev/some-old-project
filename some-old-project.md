```bash
git remote add gitadvhw1 https://github.com/DenisKarev/some-old-project.git
```
```bash
git pull gitadvhw1 main --allow-unrelated-histories
```
#### In this place fix conflicts in README.md and then commit the result.
```bash
git commit -am "resolved merge problem"
git push gitadvhw1 main
```