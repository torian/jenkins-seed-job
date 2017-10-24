String repo = 'jenkins-seed-job'

job('seed-jobs') {
  triggers {
    scm('* * * * *')
  }

  scm {
    git {
      remote {
        github("torian/$repo", 'https')
        //credentials()
      }
      branch('master')
    }
  }

  steps {
    dsl {
      external('jobs/**/JenkinsDSL.groovy')
    }
  }
}
