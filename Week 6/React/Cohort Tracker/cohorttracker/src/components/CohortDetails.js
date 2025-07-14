import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = ({ cohort }) => {
  const getStatusColor = (status) => {
    return status.toLowerCase() === 'ongoing' ? 'green' : 'blue';
  };

  return (
    <div className={styles.box}>
      <h3 
        className={styles.cohortTitle}
        style={{ color: getStatusColor(cohort.status) }}
      >
        {cohort.name}
      </h3>
      <dl className={styles.detailsList}>
        <dt>Started On</dt>
        <dd>{cohort.startDate}</dd>
        
        <dt>Current Status</dt>
        <dd>{cohort.status}</dd>
        
        <dt>Coach</dt>
        <dd>{cohort.coach}</dd>
        
        <dt>Trainer</dt>
        <dd>{cohort.trainer}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;